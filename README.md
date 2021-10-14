# JWD_Task2

Шар. Разработать классы Точка и Шар. Создать методы и тесты: вычисления площади поверхности шара, 
объёма шара, соотношения объёмов, получаемых в результате рассечения шара координатной плоскостью; 
является ли объект шаром; касается ли шар любой из координатных плоскостей.

-  Разработать entity-классы, например: «Разработать классы Точка и Фигура» 
-  Entity-классы  не  следует  наполнять  методами,  выполняющими  функциональные 
действия (методами бизнес-логики, такими как вычисление, поиск и т.д.). 
-  Фигура должна содержать поле id или name. 
-  Разработать  action-классы  реализующие  заданные  функциональности,  например: 
«Реализовать методы вычисления площади и периметра фигуры» 
-  Параметры, необходимые для создания объектов, читать из файла (.txt). Часть данных 
должна  быть  некорректной.  Если  встретилась  некорректная  строка,  приложение 
должно переходить к следующей строке. Файлы не должны находиться вне каталогов. 
-  Для  чтения  информации  из  файла  использовать  только  возможности,  появившиеся  в 
Java8. 
-  Разработать классы-валидаторы для проверки результатов вычислений параметров фигур, 
а также для валидации исходных данных для создания объектов entity-классов. 
Например:  корректная  строка  в  файле  для  создания  объекта  Круг:  «1.0  2.0  3.0»,  где 
первое второе – координаты центра, третье - радиус круга; 
некорректная строка в файле для создания объекта Круг: «2a.0 3.0 4.1» - недопустимый 
символ  «z»,  всю  строку  следует  считать  некорректной  здесь  и  в  случаях  приведенных 
ниже; 
некорректная  строка  в  файле  для  создания  объекта  Круг:  «1.0  2.0»  -  недостаточно 
информации для создания объекта (можно использовать значение по умолчанию, н-р: 1); 
некорректная  строка  в  файле  для  создания  объекта  Круг:  «1.0  2.0  -3.0»  -  невозможно 
создать Круг с отрицательным радиусом. 
-  Для  классов-сущностей  следует  переопределять  методы  класса  Object:  toString(), 
equals(), hashCode(). Методы класса Objects использовать нельзя. 
-  При решении задачи для создания entity-классов использовать паттерн Factory Method. 
-  Все классы приложения должны быть структурированы по пакетам. 
-  Использовать собственные классы исключительных ситуаций. 
-  Оформление кода должно соответствовать Java Code Convention. 
-  Для записи логов использовать Log4J2 (SLF4J). Логи писать следует в консоль и в файл. 
-  Код должен быть покрыт Unit-тестами. Использовать TestNG (JUnit). При написании тестов 
запрещено: создавать неаннотированные методы, писать логи и использовать операторы 
ветвления: if, for, while, do\while, switch; использовать в тест-методе более одного Assert-
метода.

- Все созданные объекты геометрических фигур сохранить в объекте-репозитории. Паттерн 
Repository. 
-  Разработать спецификации по поиску объектов и групп объектов в репозитории. По ID, по 
имени, по координатам (например: найти все объекты точки которых находятся в первом 
квадранте,  найти  все  объекты  площади  поверхности  (объемы,  периметры)  которых 
заключены в заданный диапазон, найти объекты находящиеся на расстоянии в заданном 
диапазоне от начала координат) 
-  Разработать методы по добавлению, удалению объектов репозитория. 
Разработать методы сортировки наборов объектов по ID, по имени, по координатам Х первой 
точки, по координатам Y первой точки и т д. Использовать интерфейс Comparator. 
-  Площади, Объемы, Периметры фигур должны храниться в объекте класса-Warehouse.  
-  Любое изменение параметра фигуры должно вызывать пересчет соответствующих значений 
в классе- Warehouse.  
Для решения данной задачи использовать паттерны Observer (можно использовать Flow 
API)  и Singleton (потокобезопасные варианты использовать запрещено). 
