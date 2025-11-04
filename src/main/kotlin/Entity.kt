package ru.it_arch.k3dm

public interface Entity : Fts {
    public val id: ValueObject
    public val content: ValueObject.Data
}
