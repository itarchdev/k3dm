package ru.it_arch.k3dm

/**
 * Определяет параметры генерируемой имплементации для [ValueObject] и [Entity]
 *
 * @property implementationName имя генерируемой имплементации. Переопределяет опцию KSP.
 * @property dsl вкл/выкл генерацию DSL. По умолчанию — true
 * @property json вкл/выкл генерацию JSON. По умолчанию — false
 * */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class Generatable(
    val implementationName: String = "",
    val dsl: Boolean = true,
    val json: Boolean = false,
)

/**
 * Определяет методы сериализации и параметры генерируемой имплементации для [ValueObject.Value] общих типов (File, URI, UUID, и т.п.)
 *
 * @property serialization метод сериализации имплементации. По умолчанию — `toString()`
 * @property deserialization способ создания имплементации. Имя статического метода. По умолчанию — через конструктор класса
 * @property useStringInDsl true — в DSL-билдере имплементация будет создаваться из строки. false — будет использоваться непосредственно
 * */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class Parsable(
    val serialization: String = "toString()",
    val deserialization: String = "",
    val useStringInDsl: Boolean = false,
)

/**
 * Определяет явное имя поля для сериализации.
 *
 * Аналог [SerialName][kotlinx.serialization.SerialName].
 * @property name имя поля.
 * */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class SerialName(val value: String)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class Ignore

/**
 * Определяет нейтральный элемент типа. Генерируется значение по умолчанию `DEFAULT`.
 * */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class Neutral

/**
 * Грязный хак для генерации аннотации @OptIn(ExperimentalSerializationApi::class).
 * Проблема в том, что штатным путем с помощью KotlinPoet ее не вставишь из-за ограничения использования. Написать:
 * ```
 * AnnotationSpec.builder(OptIn::class)
 * ```
 * не получится.
 *
 * После кодогенерации в результирующем файле
 * `import ru.it_arch.kddd.OptIn` подменяется на `import kotlinx.serialization.ExperimentalSerializationApi`
 * */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class OptIn(val markerClass: String)
