package ru.it_arch.k3dm

public interface Validatable {
    /**
     * Вызывается в процессе создания объекта для его валидации.
     *
     * В случае неуспеха должен выкидывать исключение. Предполагается использование методов [require], [requireNotNull], и т.п.
     *
     * @throws IllegalStateException
     * */
    public fun validate()
}
