/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.amd64;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_2;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;

import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.lir.amd64.AMD64ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.UnaryNode;
import org.graalvm.compiler.nodes.spi.ArithmeticLIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.type.StampTool;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;

/**
 * Count the number of trailing zeros using the {@code tzcntq} or {@code tzcntl} instructions.
 */
@NodeInfo(cycles = CYCLES_2, size = SIZE_1)
public final class AMD64CountTrailingZerosNode extends UnaryNode implements ArithmeticLIRLowerable {
    public static final NodeClass<AMD64CountTrailingZerosNode> TYPE = NodeClass.create(AMD64CountTrailingZerosNode.class);

    public AMD64CountTrailingZerosNode(ValueNode value) {
        super(TYPE, computeStamp(value.stamp(NodeView.DEFAULT), value), value);
        assert value.getStackKind() == JavaKind.Int || value.getStackKind() == JavaKind.Long;
    }

    @Override
    public Stamp foldStamp(Stamp newStamp) {
        return computeStamp(newStamp, getValue());
    }

    static Stamp computeStamp(Stamp newStamp, ValueNode value) {
        assert newStamp.isCompatible(value.stamp(NodeView.DEFAULT));
        IntegerStamp valueStamp = (IntegerStamp) newStamp;
        return StampTool.stampForTrailingZeros(valueStamp);
    }

    public static ValueNode tryFold(ValueNode value) {
        if (value.isConstant()) {
            JavaConstant c = value.asJavaConstant();
            if (value.getStackKind() == JavaKind.Int) {
                return ConstantNode.forInt(Integer.numberOfTrailingZeros(c.asInt()));
            } else {
                return ConstantNode.forInt(Long.numberOfTrailingZeros(c.asLong()));
            }
        }
        return null;
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode folded = tryFold(forValue);
        return folded != null ? folded : this;
    }

    @Override
    public void generate(NodeLIRBuilderTool builder, ArithmeticLIRGeneratorTool gen) {
        builder.setResult(this, ((AMD64ArithmeticLIRGeneratorTool) gen).emitCountTrailingZeros(builder.operand(getValue())));
    }
}
