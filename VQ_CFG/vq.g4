grammar vq;
query
      : gradient? exp EOF;

gradient
      : '[' oneGradient ',' oneGradient ']';

oneGradient 
      : ID ':' NEG? NAT
      | ID;

exp 
      : '(' exp ')'                                    #par
      | op ='-' exp                                    #unOp
      | op ='!' exp                                    #unOp
      | exp op=('*' | '/') exp                         #binOp
      | exp op=('+' | '-') exp                         #binOp
      | exp op=('<' | '<=' | '>' | '>=') exp           #binOp
      | exp op=('==' | '!=') exp                       #binOp
      | exp op='&&' exp                                #binOp
      | exp op='||' exp                                #binOp
      | exp '?' exp ':' exp                            #condOp
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