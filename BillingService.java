public class BillingService {

    public static class CustomerProfile {
        public int userId;
        public String email;
        public String passwordHash;
        public String city;
        public int loyaltyPoints;

        public CustomerProfile(int userId, String email, String passwordHash, String city, int loyaltyPoints) {
            this.userId = userId;
            this.email = email;
            this.passwordHash = passwordHash;
            this.city = city;
            this.loyaltyPoints = loyaltyPoints;
        }
    }

    // Усунуто Stamp Coupling: передаємо лише примітивні параметри city та weightKg
        public static double calculateDeliveryCost(String city, double weightKg) {
            double baseRate;
            if ("Ivano-Frankivsk".equals(city)) {
                baseRate = 50.0;
            } else if ("Kyiv".equals(city)) {
                baseRate = 80.0;
            } else {
                baseRate = 110.0;
            }
            return baseRate + (weightKg * 12.0);
        }

    // Усунуто Common та Control Coupling: явний параметр taxRate + окремий метод без modeFlag
    public static String processStandardInvoice(double amount, String city, double weightKg, double taxRate) {
        double delivery = calculateDeliveryCost(city, weightKg);
        double total = (amount * (1 + taxRate)) + delivery;
        return "PROCESSED: " + Math.round(total * 100.0) / 100.0;
    }

    // Перевантажений метод зі ставкою податку за замовчуванням 0.20
    public static String processStandardInvoice(double amount, String city, double weightKg) {
        return processStandardInvoice(amount, city, weightKg, 0.20);
    }

    public static String processTaxExemptInvoice(double amount, String city, double weightKg) {
        double delivery = calculateDeliveryCost(city, weightKg);
        double total = amount + delivery;
        return "TAX_EXEMPT: " + Math.round(total * 100.0) / 100.0;
    }
}
