/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.j2cl.ast;

import com.google.j2cl.ast.processors.Visitable;

/**
 * Class for Prefix Expression.
 */
@Visitable
public class PrefixExpression extends Expression {
  @Visitable Expression operand;
  private PrefixOperator operator;

  public PrefixExpression(Expression operand, PrefixOperator operator) {
    this.operand = operand;
    this.operator = operator;
  }

  public Expression getOperand() {
    return operand;
  }

  public PrefixOperator getOperator() {
    return operator;
  }

  public void setOperand(Expression operand) {
    this.operand = operand;
  }

  public void setOperator(PrefixOperator operator) {
    this.operator = operator;
  }

  @Override
  public PrefixExpression accept(Processor processor) {
    return Visitor_PrefixExpression.visit(processor, this);
  }
}
