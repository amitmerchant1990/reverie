package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ArrowLibraryAccessors laccForArrowLibraryAccessors = new ArrowLibraryAccessors(owner);
    private final CoroutinesLibraryAccessors laccForCoroutinesLibraryAccessors = new CoroutinesLibraryAccessors(owner);
    private final DokkaLibraryAccessors laccForDokkaLibraryAccessors = new DokkaLibraryAccessors(owner);
    private final KnitLibraryAccessors laccForKnitLibraryAccessors = new KnitLibraryAccessors(owner);
    private final KotestLibraryAccessors laccForKotestLibraryAccessors = new KotestLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

    /**
     * Returns the group of libraries at arrow
     */
    public ArrowLibraryAccessors getArrow() { return laccForArrowLibraryAccessors; }

    /**
     * Returns the group of libraries at coroutines
     */
    public CoroutinesLibraryAccessors getCoroutines() { return laccForCoroutinesLibraryAccessors; }

    /**
     * Returns the group of libraries at dokka
     */
    public DokkaLibraryAccessors getDokka() { return laccForDokkaLibraryAccessors; }

    /**
     * Returns the group of libraries at knit
     */
    public KnitLibraryAccessors getKnit() { return laccForKnitLibraryAccessors; }

    /**
     * Returns the group of libraries at kotest
     */
    public KotestLibraryAccessors getKotest() { return laccForKotestLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class ArrowLibraryAccessors extends SubDependencyFactory {
        private final ArrowCoreLibraryAccessors laccForArrowCoreLibraryAccessors = new ArrowCoreLibraryAccessors(owner);

        public ArrowLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fx (io.arrow-kt:arrow-fx-coroutines)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFx() { return create("arrow.fx"); }

            /**
             * Creates a dependency provider for optics (io.arrow-kt:arrow-optics)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOptics() { return create("arrow.optics"); }

        /**
         * Returns the group of libraries at arrow.core
         */
        public ArrowCoreLibraryAccessors getCore() { return laccForArrowCoreLibraryAccessors; }

    }

    public static class ArrowCoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ArrowCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.arrow-kt:arrow-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("arrow.core"); }

            /**
             * Creates a dependency provider for test (io.arrow-kt:arrow-core-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("arrow.core.test"); }

    }

    public static class CoroutinesLibraryAccessors extends SubDependencyFactory {

        public CoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("coroutines.core"); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("coroutines.test"); }

    }

    public static class DokkaLibraryAccessors extends SubDependencyFactory {

        public DokkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.dokka:dokka-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("dokka.core"); }

    }

    public static class KnitLibraryAccessors extends SubDependencyFactory {

        public KnitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-knit-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("knit.test"); }

    }

    public static class KotestLibraryAccessors extends SubDependencyFactory {

        public KotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for assertionsCore (io.kotest:kotest-assertions-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAssertionsCore() { return create("kotest.assertionsCore"); }

            /**
             * Creates a dependency provider for frameworkEngine (io.kotest:kotest-framework-engine)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFrameworkEngine() { return create("kotest.frameworkEngine"); }

            /**
             * Creates a dependency provider for property (io.kotest:kotest-property)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProperty() { return create("kotest.property"); }

            /**
             * Creates a dependency provider for runnerJUnit5 (io.kotest:kotest-runner-junit5)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRunnerJUnit5() { return create("kotest.runnerJUnit5"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinTestLibraryAccessors laccForKotlinTestLibraryAccessors = new KotlinTestLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for stdlibCommon (org.jetbrains.kotlin:kotlin-stdlib-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStdlibCommon() { return create("kotlin.stdlibCommon"); }

            /**
             * Creates a dependency provider for stdlibJDK8 (org.jetbrains.kotlin:kotlin-stdlib-jdk8)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStdlibJDK8() { return create("kotlin.stdlibJDK8"); }

            /**
             * Creates a dependency provider for stdlibJS (org.jetbrains.kotlin:kotlin-stdlib-js)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStdlibJS() { return create("kotlin.stdlibJS"); }

        /**
         * Returns the group of libraries at kotlin.test
         */
        public KotlinTestLibraryAccessors getTest() { return laccForKotlinTestLibraryAccessors; }

    }

    public static class KotlinTestLibraryAccessors extends SubDependencyFactory {

        public KotlinTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (org.jetbrains.kotlin:kotlin-test-junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("kotlin.test.junit"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: arrow (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getArrow() { return getVersion("arrow"); }

            /**
             * Returns the version associated to this alias: arrowGradleConfig (0.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getArrowGradleConfig() { return getVersion("arrowGradleConfig"); }

            /**
             * Returns the version associated to this alias: coroutines (1.5.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("coroutines"); }

            /**
             * Returns the version associated to this alias: dokka (1.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDokka() { return getVersion("dokka"); }

            /**
             * Returns the version associated to this alias: githooks (0.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGithooks() { return getVersion("githooks"); }

            /**
             * Returns the version associated to this alias: knit (0.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKnit() { return getVersion("knit"); }

            /**
             * Returns the version associated to this alias: kotest (5.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotest() { return getVersion("kotest"); }

            /**
             * Returns the version associated to this alias: kotestGradle (5.0.0.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotestGradle() { return getVersion("kotestGradle"); }

            /**
             * Returns the version associated to this alias: kotlin (1.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: kotlinBinaryCompatibilityValidator (0.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinBinaryCompatibilityValidator() { return getVersion("kotlinBinaryCompatibilityValidator"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final ArrowGradleConfigPluginAccessors baccForArrowGradleConfigPluginAccessors = new ArrowGradleConfigPluginAccessors(providers, config);
        private final KotestPluginAccessors baccForKotestPluginAccessors = new KotestPluginAccessors(providers, config);
        private final KotlinPluginAccessors baccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for dokka to the plugin id 'org.jetbrains.dokka'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDokka() { return createPlugin("dokka"); }

            /**
             * Creates a plugin provider for githooks to the plugin id 'com.github.jakemarsden.git-hooks'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getGithooks() { return createPlugin("githooks"); }

            /**
             * Creates a plugin provider for knit to the plugin id 'org.jetbrains.kotlinx:kotlinx-knit'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKnit() { return createPlugin("knit"); }

        /**
         * Returns the group of bundles at plugins.arrowGradleConfig
         */
        public ArrowGradleConfigPluginAccessors getArrowGradleConfig() { return baccForArrowGradleConfigPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotest
         */
        public KotestPluginAccessors getKotest() { return baccForKotestPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() { return baccForKotlinPluginAccessors; }

    }

    public static class ArrowGradleConfigPluginAccessors extends PluginFactory {

        public ArrowGradleConfigPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for arrowGradleConfig.formatter to the plugin id 'io.arrow-kt.arrow-gradle-config-formatter'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getFormatter() { return createPlugin("arrowGradleConfig.formatter"); }

            /**
             * Creates a plugin provider for arrowGradleConfig.multiplatform to the plugin id 'io.arrow-kt.arrow-gradle-config-multiplatform'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("arrowGradleConfig.multiplatform"); }

            /**
             * Creates a plugin provider for arrowGradleConfig.nexus to the plugin id 'io.arrow-kt.arrow-gradle-config-nexus'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getNexus() { return createPlugin("arrowGradleConfig.nexus"); }

            /**
             * Creates a plugin provider for arrowGradleConfig.publishMultiplatform to the plugin id 'io.arrow-kt.arrow-gradle-config-publish-multiplatform'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getPublishMultiplatform() { return createPlugin("arrowGradleConfig.publishMultiplatform"); }

    }

    public static class KotestPluginAccessors extends PluginFactory {

        public KotestPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotest.multiplatform to the plugin id 'io.kotest.multiplatform'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("kotest.multiplatform"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.binaryCompatibilityValidator to the plugin id 'org.jetbrains.kotlinx.binary-compatibility-validator'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getBinaryCompatibilityValidator() { return createPlugin("kotlin.binaryCompatibilityValidator"); }

            /**
             * Creates a plugin provider for kotlin.multiplatform to the plugin id 'org.jetbrains.kotlin.multiplatform'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("kotlin.multiplatform"); }

    }

}
