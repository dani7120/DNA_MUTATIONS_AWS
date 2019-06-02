pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        echo 'Git clone'
      }
    }
    stage('Maven Build') {
      parallel {
        stage('Maven Build') {
          steps {
            echo 'Maven build'
          }
        }
        stage('Maven-clean') {
          steps {
            sh 'mvn clean'
          }
        }
        stage('Maven-install') {
          steps {
            sh 'mvn install'
          }
        }
      }
    }
  }
}