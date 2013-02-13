@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module util::MapHelper

@doc{
Synopsis: Delete a key from a map.

Description:
Returns the map `m` minus the key `k`.

Examples:
<screen>
import Map;
delete(("apple":1,"pear":2), "apple");
</screen>
}
public map[&K,&V] delete(map[&K,&V] m, &K k) = 
  (key: m[key] | &K key <- m, key != k);
