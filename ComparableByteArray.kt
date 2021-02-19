class ComparableByteArray constructor(val array: ByteArray): Collection<Byte> {
    override val size: Int
        get() = array.size

    constructor(size: Int) : this(ByteArray(size))
    constructor(other: ComparableByteArray) : this(other.array.copyOf())

    override fun equals(other: Any?): Boolean =
        (this === other) || (javaClass == other?.javaClass && array.contentEquals((other as ComparableByteArray).array))
    override fun hashCode(): Int = array.contentHashCode()
    override fun toString(): String = array.toString()
    operator fun get(index: Int) = array[index]
    operator fun set(index: Int, value: Byte) = array.set(index, value)
    override operator fun iterator(): ByteIterator = array.iterator()
    override fun contains(element: Byte): Boolean = array.contains(element)
    override fun containsAll(elements: Collection<Byte>): Boolean = TODO("Not implemented")
    override fun isEmpty(): Boolean = array.isEmpty()
}
