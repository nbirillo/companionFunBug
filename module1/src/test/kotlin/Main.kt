import a.A
import a.getResourcesRootPath
import b.B

fun main() {
    println(::B.javaClass.getResource("data")?.path)
    println(getResourcesRootPath(::B, "data"))
    println(A.getResourcesRootPathWithBug(::B, "data"))
}