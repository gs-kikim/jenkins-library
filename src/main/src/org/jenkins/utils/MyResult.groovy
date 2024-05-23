package org.jenkins.utils
import groovy.json.JsonSlurper

class MyResult {
    static load_json_params() {
        def jsonSlurper = new JsonSlurper()
        def config = jsonSlurper.parse(new File('src/main/resources/config.json'))
        return config
    }
}