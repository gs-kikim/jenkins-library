package com.jenkins.library

import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource

class TestSharedLibraryValidateString extends DeclarativePipelineTest {

    private final String JOB_NAME = "test_validate_string"
    private final String JOB_PATH = "job/library/${JOB_NAME}.jenkins"
    private final String LIB_DIR = "src/main"
    private final String BINDING_VAR = "inputString"

    @Override
    @BeforeEach
    void setUp() throws Exception {
        scriptRoots += 'src/test/jenkins'
        super.setUp()
        def library = library().name('jenkins_library')
                .retriever(projectSource(LIB_DIR))
                .defaultVersion("master")
                .targetPath(LIB_DIR)
                .allowOverride(true)
                .implicit(false)
                .build()
        helper.registerSharedLibrary(library)
    }


    @Test
    void gpf_file_validate__test() {
        String file = "/tftpboot/NAC/AGENT/Plugin/ACT2008_ThreatDetector/V5.0/BETA/Insights2.0.1/IE-B-39507-2.0.128.0513_(NAC-V50-ThreatDetector2).gpf"

        // 파라미터를 설정합니다.
        binding.setVariable(BINDING_VAR, file)

        // 파라미터를 사용하여 스크립트를 실행합니다.
        def script = loadScript(JOB_PATH)
        script.params = [inputString: file]

        script.run()
        printCallStack()
        assertJobStatusSuccess()
    }

    @Test
    void img_file_validate__test() {
        String file = "/tftpboot/INSIGHTS/GNOS/v2.0.1/RC/AAT/INSIGHTS-CT64-R-39547-2.0.127.0520.img"

        // 파라미터를 설정합니다.
        binding.setVariable(BINDING_VAR, file)

        // 파라미터를 사용하여 스크립트를 실행합니다.
        def script = loadScript(JOB_PATH)
        script.params = [inputString: file]

        script.run()
        printCallStack()
        assertJobStatusSuccess()
    }

}