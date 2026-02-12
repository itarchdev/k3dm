package ru.it_arch.k3dm

public interface Entity : Fts, Validatable {
    public val id: ValueObject
    public val content: ValueObject.Data
}
