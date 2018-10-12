package com.example.kuxu.gistviewerforandroid.infra

import androidx.test.platform.app.InstrumentationRegistry
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
internal class AccessTokenRepositoryImplSpek : SubjectSpek<AccessTokenRepositoryImpl>({
    val context = InstrumentationRegistry.getInstrumentation().context
    subject {
        AccessTokenRepositoryImpl((context))
    }
    given("アクセストークンを保存したり読み込んだりできる") {

        val dummyValue = "hoge"


        on("アクセストークンを保存") {
            subject.saveAccessToken(dummyValue)
        }

        on("アクセストークンの読み込み") {
            it("アクセストークンを読み込めた") {
                val actualAccessTokenLoadResult = subject.loadAccessToken()
                Assert.assertEquals(dummyValue, actualAccessTokenLoadResult)
            }
        }
    }
})