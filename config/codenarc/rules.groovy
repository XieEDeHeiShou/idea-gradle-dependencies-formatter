ruleset {
    ruleset('file:config/codenarc/StarterRuleSet-AllRulesByCategory.groovy') {
        AbstractClassWithoutAbstractMethod(enabled: false)
        AbstractClassWithPublicConstructor(enabled: false)
        ClassJavadoc(enabled: false)
        ClosureAsLastMethodParameter(enabled: false)
        CrapMetric(enabled: false)
        DuplicateNumberLiteral(enabled: false)
        DuplicateStringLiteral(enabled: false)
        FactoryMethodName(enabled: false)
        GStringExpressionWithinString(enabled: false)
        JUnitPublicNonTestMethod(enabled: false)
        JUnitTestMethodWithoutAssert(enabled: false)
        LineLength(length: 140)
        MethodName(enabled: false)
        NoDef(enabled: false)
        PrivateFieldCouldBeFinal(enabled: false)
        SpaceAroundMapEntryColon(enabled: false)
        UnnecessaryBooleanExpression(enabled: false)
        UnnecessaryGString(enabled: false)
        UnusedObject(enabled: false)
    }
}