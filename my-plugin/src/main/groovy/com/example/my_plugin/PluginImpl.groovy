package com.example.my_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class PluginImpl implements Plugin<Project> {
    @Override
    void apply(Project project) {
        /*  project.task('ohYeahTask') {
              println("hello my plugin")
          }*/
        Task feifeiTask = project.tasks.create("feifeiTask") {
            doLast {
                println("hello my plugin")
            }
        }
        project.afterEvaluate {
            Task compressDebugAssets = project.tasks.findByName("compressDebugAssets")
            if (compressDebugAssets != null) {
                compressDebugAssets.finalizedBy(feifeiTask)
            }
        }
    }
}