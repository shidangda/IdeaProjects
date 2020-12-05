/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.phases.util;

import org.graalvm.compiler.core.common.spi.CodeGenProviders;
import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.nodes.spi.LoweringProvider;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.nodes.spi.StampProvider;
import org.graalvm.compiler.phases.tiers.PhaseContext;

import jdk.vm.ci.code.CodeCacheProvider;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * A set of providers, some of which may not be present (i.e., null).
 */
public class Providers implements CodeGenProviders {

    private final MetaAccessProvider metaAccess;
    private final CodeCacheProvider codeCache;
    private final LoweringProvider lowerer;
    private final ConstantReflectionProvider constantReflection;
    private final ConstantFieldProvider constantFieldProvider;
    private final ForeignCallsProvider foreignCalls;
    private final Replacements replacements;
    private final StampProvider stampProvider;

    public Providers(MetaAccessProvider metaAccess, CodeCacheProvider codeCache, ConstantReflectionProvider constantReflection, ConstantFieldProvider constantFieldProvider,
                    ForeignCallsProvider foreignCalls, LoweringProvider lowerer, Replacements replacements, StampProvider stampProvider) {
        this.metaAccess = metaAccess;
        this.codeCache = codeCache;
        this.constantReflection = constantReflection;
        this.constantFieldProvider = constantFieldProvider;
        this.foreignCalls = foreignCalls;
        this.lowerer = lowerer;
        this.replacements = replacements;
        this.stampProvider = stampProvider;
    }

    public Providers(Providers copyFrom) {
        this(copyFrom.getMetaAccess(), copyFrom.getCodeCache(), copyFrom.getConstantReflection(), copyFrom.getConstantFieldProvider(), copyFrom.getForeignCalls(), copyFrom.getLowerer(),
                        copyFrom.getReplacements(), copyFrom.getStampProvider());
    }

    public Providers(PhaseContext copyFrom) {
        this(copyFrom.getMetaAccess(), null, copyFrom.getConstantReflection(), copyFrom.getConstantFieldProvider(), null, copyFrom.getLowerer(), copyFrom.getReplacements(),
                        copyFrom.getStampProvider());
    }

    @Override
    public MetaAccessProvider getMetaAccess() {
        return metaAccess;
    }

    @Override
    public CodeCacheProvider getCodeCache() {
        return codeCache;
    }

    @Override
    public ForeignCallsProvider getForeignCalls() {
        return foreignCalls;
    }

    public LoweringProvider getLowerer() {
        return lowerer;
    }

    @Override
    public ConstantReflectionProvider getConstantReflection() {
        return constantReflection;
    }

    public ConstantFieldProvider getConstantFieldProvider() {
        return constantFieldProvider;
    }

    public Replacements getReplacements() {
        return replacements;
    }

    public StampProvider getStampProvider() {
        return stampProvider;
    }

    public Providers copyWith(MetaAccessProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(substitution, codeCache, constantReflection, constantFieldProvider, foreignCalls, lowerer, replacements, stampProvider);
    }

    public Providers copyWith(CodeCacheProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, substitution, constantReflection, constantFieldProvider, foreignCalls, lowerer, replacements, stampProvider);
    }

    public Providers copyWith(ConstantReflectionProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, codeCache, substitution, constantFieldProvider, foreignCalls, lowerer, replacements, stampProvider);
    }

    public Providers copyWith(ConstantFieldProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, codeCache, constantReflection, substitution, foreignCalls, lowerer, replacements, stampProvider);
    }

    public Providers copyWith(ForeignCallsProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, codeCache, constantReflection, constantFieldProvider, substitution, lowerer, replacements, stampProvider);
    }

    public Providers copyWith(LoweringProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, codeCache, constantReflection, constantFieldProvider, foreignCalls, substitution, replacements, stampProvider);
    }

    public Providers copyWith(Replacements substitution) {
        assert this.getClass() == Providers.class : "must override in " + getClass();
        return new Providers(metaAccess, codeCache, constantReflection, constantFieldProvider, foreignCalls, lowerer, substitution, stampProvider);
    }

    public Providers copyWith(StampProvider substitution) {
        assert this.getClass() == Providers.class : "must override";
        return new Providers(metaAccess, codeCache, constantReflection, constantFieldProvider, foreignCalls, lowerer, replacements, substitution);
    }
}
