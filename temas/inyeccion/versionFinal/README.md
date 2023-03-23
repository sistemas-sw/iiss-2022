
# Inyeccion

+ He creado una interfaz para BankAccount, IBankAccount.
+ He creado un módulo de Guice que proporcione una instancia de BankAccount a la clase BankAccountComparatorById
+ He creado una instancia de Injector que use su método getInstance() para obtener una instancia de BankAccountComparatorById con la dependencia de BankAccount inyectada: