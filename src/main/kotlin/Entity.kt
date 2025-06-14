package ru.it_arch.k3dm

public interface Entity : Kddd {
    public val id: ValueObject
    public var content: ValueObject.Data
}
