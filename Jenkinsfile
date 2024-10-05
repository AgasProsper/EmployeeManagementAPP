pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                echo "building Maven App..."
                sh "mvn clean package -DskipTests=true"            
            }
        }
        stage('build image') {
            steps {
                echo "building docker image"
                script {
                    withCredentials([usernamePassword(credentialsId: 'DockerHub-secret', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t agasprosper/employee-management-backend:${BUILD_ID} .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push agasprosper/employee-management-backend:${BUILD_ID}'
                    }
                }
            } 
        }
        stage('deploy') {
            steps {
                echo "this is the deploy stage" 
            }
        }
    }
}