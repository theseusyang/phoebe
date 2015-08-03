/*
 * Copyright © 2015, 8Kdata Technology S.L.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for any purpose, without fee, and without
 * a written agreement is hereby granted, provided that the above
 * copyright notice and this paragraph and the following two
 * paragraphs appear in all copies.
 *
 * In no event shall 8Kdata Technology S.L. be liable to any party
 * for direct, indirect, special, incidental, or consequential
 * damages, including lost profits, arising out of the use of this
 * software and its documentation, even if 8Kdata Technology S.L.
 * has been advised of the possibility of such damage.
 *
 * 8Kdata Technology S.L. specifically disclaims any warranties,
 * including, but not limited to, the implied warranties of
 * merchantability and fitness for a particular purpose. the
 * software provided hereunder is on an “as is” basis, and
 * 8Kdata Technology S.L. has no obligations to provide
 * maintenance, support, updates, enhancements, or modifications.
 */

package com.eightkdata.phoebe.common.message;

import com.eightkdata.phoebe.common.Encoders;
import com.eightkdata.phoebe.common.FeBeMessage;
import com.eightkdata.phoebe.common.FeBeMessageType;

import javax.annotation.concurrent.Immutable;
import java.nio.charset.Charset;

@Immutable
public class CommandComplete implements FeBeMessage {

    private final String commandTag;

    public CommandComplete(String commandTag) {
        this.commandTag = commandTag;
    }

    public String getCommandTag() {
        return commandTag;
    }

    @Override
    public FeBeMessageType getType() {
        return FeBeMessageType.CommandComplete;
    }

    @Override
    public int computePayloadLength(Charset encoding) {
        return Encoders.stringLength(commandTag, encoding);
    }

    @Override
    public String toString() {
        return "CommandComplete(" + commandTag + ")";
    }

}