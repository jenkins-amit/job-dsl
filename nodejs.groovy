job('nodejs-example') {
    scm {
        git('https://github.com/jenkins-amit/node-demo.git') { node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@jenkins.com')
        }
    }

    triggers {
        scm('H/5 * * * *')
    }

    wrappers {
        nodejs('nodejs17')
    }

    step {
        shell('npm install')
    }
}