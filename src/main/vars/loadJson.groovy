import com.google.gson.Gson
import groovy.json.JsonSlurper
import org.jenkins.utils.MyResult

call() {
    def jsonSlurper = new JsonSlurper()
    def config = jsonSlurper.parse(new File('src/main/resources/config.json'))
    return config
}
