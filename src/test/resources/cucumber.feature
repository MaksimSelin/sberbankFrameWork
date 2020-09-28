#language: ru
Функционал: Ипотека

  @negative
  @checkTheMismatchOfTheInterestRateField
  Сценарий: Заполнение формы
    * Загрузка стартовой траницы
    * Клик по иконки Ипотека
    * Клик ипотека на готовое жилье
    * Заполнение формы
      | цена                 | 5180000 |
      | первоначальный взнос | 3058000 |
      | срок кредитования    | 30      |
      | страхование жизни    | false   |
      | молодая семья        | true    |
    * Проверка полей
      | ежемесячный платеж | 16 017 ₽    |
      | сумма кредита      | 2 122 000 ₽ |
      | необходимый доход  | 20 618 ₽    |
      | процентная ставка  | 11%         |