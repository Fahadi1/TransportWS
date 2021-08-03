pipeline {
    agent any
    tools {
        maven 'M3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                  git branch: 'master', url:'https://github.com/Fahadi1/TransportWS.git'
					sh 'mvn clean'
                script {
                try {
                sh 'docker stop ctransportws && docker rm ctransportws'
                } catch (Exception e) {
                    sh 'echo "---=--- No container to remove ---=---" '
                }
            }
        }
        }
		
		stage('Compile') {
            steps {
                sh 'echo "---=--- Compile ---=---"'
                sh 'mvn -DskipTests clean compile'
            }
        }
        
        
        stage('package'){
            steps {
                sh 'echo "---=--- Package ---=---"'
                sh 'mvn -DskipTests package'
            }
              post {
            always {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        } 
        }
        
        stage('SSH transfert') {
        steps {
            script {
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'ec2-host', transfers:[
                        sshTransfer(
                          execCommand: '''
                                echo "-=- Cleaning project -=-"
                                sudo docker stop ctransportws  || true
                                sudo docker rm ctransportws || true
                                sudo docker rmi bertromain/ctransportws:1.0 || true
                            '''
                        ),
                        sshTransfer(
                            sourceFiles:"target/*.jar",
                            removePrefix: "target",
                            remoteDirectory: "//home//ec2-user",
                            execCommand: "ls /home/ec2-user"
                        ),
                        sshTransfer(
                            sourceFiles:"Dockerfile",
                            removePrefix: "",
                            remoteDirectory: "//home//ec2-user",
                            execCommand: '''
                                cd /home/vagrant;
                                sudo docker build -t bertromain/transportws:1.0 .; 
                                sudo docker run -d --name ctransportws -p 8086:8086 bertromain/transportws:1.0;
                            '''
                        )
                    ])
                ])                
            }
        }
    }
    }
    
}
