package org.uva.sea.ql.type.impl;

import org.uva.sea.ql.type.Type;

/**
 * TODO put some documentation !!
 *
 * @author Ammar.Hamid
 *         Date: 2/10/13 10:30 PM
 */
public class StringType extends Type
{

    @Override
    public boolean isCompatibleTo(Type type)
    {
        return type.isCompatibleToString();
    }

    @Override
    public boolean isCompatibleToString()
    {
        return true;
    }

}
