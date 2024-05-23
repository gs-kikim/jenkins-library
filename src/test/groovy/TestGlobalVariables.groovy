import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource

class TestGlobalVariables extends BasePipelineTest  {

    private final String LIB_DIR = "src/main"
    String sharedLibs = new File(LIB_DIR).getAbsolutePath()

    @Override
    @BeforeEach
    void setUp() throws Exception {
        scriptRoots += 'src/test/jenkins'
        super.setUp()
        def library = library().name('jenkins_library')
                .retriever(projectSource(sharedLibs))
                .defaultVersion("master")
                .targetPath(sharedLibs)
                .allowOverride(false)
                .implicit(false)
                .build()
        helper.registerSharedLibrary(library)
    }

    @Test
    void global_vars_test() {
        def script = loadScript("job/test_global_variable.jenkins")

        script.run()
        printCallStack()
        assertJobStatusSuccess()
    }
}