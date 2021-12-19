job('nodejs docker app') {
    scm {
        git('https://github.com/jenkins-amit/node-demo.git') { node ->
            node / gitConfigName('JOB DSL')
            node / gitConfigEmail('jenkins-dsl@jenkins.com')
        }
    }

    triggers {
        scm('H/5 * * * *')
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('amit0511/nodejs-app')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('DockerLoginCreds')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}