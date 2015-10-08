package com.github.platan.idea.dependencies.intentions

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.psi.impl.source.PostprocessReformattingAspect
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase

abstract class IntentionTestBase extends LightCodeInsightFixtureTestCase {

    protected final String intention

    IntentionTestBase(String intentionName) {
        assert intentionName != null
        this.intention = intentionName
    }

    protected void doTextTest(String given, String expected) {
        myFixture.configureByText("build.gradle", given)
        List<IntentionAction> list = myFixture.filterAvailableIntentions(intention)
        assert list.size() == 1
        myFixture.launchAction(list)
        PostprocessReformattingAspect.getInstance(project).doPostponedFormatting()
        myFixture.checkResult(expected)
    }

    protected void doAntiTest(String given) {
        myFixture.configureByText("build.gradle", given)
        assert !myFixture.filterAvailableIntentions(intention), "An intention '$intention' should not be applicable to: \n$given\n"
    }

    protected void doTest() {
        myFixture.configureByFile(getTestName(false).replaceFirst('_', '') + ".gradle")
        List<IntentionAction> list = myFixture.filterAvailableIntentions(intention)
        assert list.size() == 1
        myFixture.launchAction(list)
        PostprocessReformattingAspect.getInstance(project).doPostponedFormatting()
        myFixture.checkResultByFile(getTestName(false).replaceFirst('_', '') + "_after.gradle")
    }

}
