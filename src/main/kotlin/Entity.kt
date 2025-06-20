package ru.it_arch.k3dm

public interface Entity : Fts {
    public val id: ValueObject
    public var content: ValueObject.Data
}
