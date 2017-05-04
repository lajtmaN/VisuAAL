grammar vq;
query
      : (gradient | colors)? exp EOF;

gradient
      : '[' oneGradient ',' oneGradient ']';

oneGradient 
      : ID ':' NEG? NAT
      | ID;

colors
      : '[' color+ ID ':' '*' ']';

color
      : ID ':' NEG? NAT ',';

exp 
      : '(' exp ')'                                    #par
      | <assoc=right> op ='-' exp                                    #unOp
      | <assoc=right> op ='!' exp                                    #unOp
      | exp op=('*' | '/') exp                         #binOp
      | exp op=('+' | '-') exp                         #binOp
      | exp op=('<' | '<=' | '>' | '>=') exp           #binOp
      | exp op=('==' | '!=') exp                       #binOp
      | exp op='&&' exp                                #binOp
      | exp op='||' exp                                #binOp
      | <assoc=right> exp '?' exp ':' exp              #condOp
      | ID                                             #id
      | ID '.' ID                                      #idDot
      | NAT                                            #nat
      | FLOAT                                          #float
      | BOOL                                           #bool
      ;

BOOL  : 'true' | 'false';
NEG   : '-';
ID    : [a-zA-Z_]([a-zA-Z0-9_])*;
NAT   : [0-9]+;
FLOAT : [0-9]+('.'[0-9]+)?;
WS    : [ \n\t\r]+ -> channel(HIDDEN);