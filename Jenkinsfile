pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_6') {
                    sh 'mvn clean compile'
                }
            }
        }



    }
}
