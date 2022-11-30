package a

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.reflect.KFunction

open class A(private val testDataRoot: String) : BasePlatformTestCase() {

    override fun getTestDataPath() = testDataRoot

    companion object {
        const val resourcesRoot: String = "data"

        fun getResourcesRootPathWithBug(
            cls: KFunction<A>,
            resourcesRootName: String = resourcesRoot,
        ): String =
            cls.javaClass.getResource(resourcesRootName)?.path ?: error("Resource $resourcesRootName does not exist")
    }
}

fun getResourcesRootPath(
    cls: KFunction<A>, resourcesRootName: String = A.resourcesRoot
): String = cls.javaClass.getResource(resourcesRootName)?.path ?: error("Resource $resourcesRootName does not exist")