pipeline {
    agent any
    stages {
        stage('Run Test') {
            steps {
                withMaven(maven: '') {
                    bat "mvn clean test -Dcucumber.filter.tags='${TAG}'"
                }
            }
        }
        stage("Allure Report Generation") {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/reports/allure-results']]
            }
        }
    }
    post {
        always {
            cleanWs notFailBuild: true
        }
    }
}
