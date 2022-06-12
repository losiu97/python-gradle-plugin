package com.pswidersk.gradle.python

import org.gradle.api.Plugin
import org.gradle.api.Project

class PythonPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = with(project) {
        extensions.create(PYTHON_PLUGIN_EXTENSION_NAME, PythonPluginExtension::class.java)
        tasks.register<ListPropertiesTask>("listPluginProperties") { }
        val minicondaSetupTask = tasks.register<MinicondaSetupTask>("minicondaSetup") { }
        tasks.register<EnvSetupTask>("envSetup") {
            it.dependsOn(minicondaSetupTask)
        }
    }

}
