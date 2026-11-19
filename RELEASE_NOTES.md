# Release Notes — v1.1.0

## Added
- Додано спеціальний базовий тариф доставки `80.0` для міста `Kyiv`.
- Додано явний параметр ставки податку `taxRate` у метод `processStandardInvoice` та його перевантажену версію зі ставкою `0.20` за замовчуванням.

## Changed
- Коефіцієнт вартості доставки за кілограм ваги (`weightKg`) збільшено з `12.0` до `15.0`.
- Виконано рефакторинг модуля `BillingService`: перехід від Common, Stamp та Control Coupling до Data Coupling.

## Breaking Changes
- Змінено сигнатуру методу `calculateDeliveryCost`: тепер він приймає примітив `String city` замість об'єкта `CustomerProfile`.
- Видалено статичну глобальну змінну `GLOBAL_TAX_RATE`.
- Видалено метод `processInvoice` з керуючим прапорцем `modeFlag`; замість нього впроваджено окремі методи `processStandardInvoice` та `processTaxExemptInvoice`.
