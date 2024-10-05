pipeline {
    agent any
    tools {
        nodejs 'Node'
    }
    stages {
        stage('build') {
            steps {
                echo "building Node application..."
                sh "npm install"
                sh "npm run build"             
            }
        }
        stage('build image') {
            steps {
                echo "building docker image"
                script {
                    withCredentials([usernamePassword(credentialsId: 'DockerHub-secret', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t agasprosper/employee-management-frontend:${BUILD_ID} .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push agasprosper/employee-management-frontend:${BUILD_ID}'
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