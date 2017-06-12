grammar vq;
query
      : (gradient | colors)? exp EOF;

gradient
      : '[' oneGradient ',' oneGradient ']';

oneGradient 
      : ID ':' NEG? FLOAT
      | ID ':' min
      | ID ':' max
      | ID
      ;

min
      : 'min';

max
      : 'max';

colors
      : '[' color+ ID ':' '*' ']';

color
      : ID ':' NEG? FLOAT ',';

exp 
      : '(' exp ')'                                    #par
      | <assoc=right> op ='-' exp                      #unOp
      | <assoc=right> op ='!' exp                      #unOp
      | exp op=('*' | '/') exp                         #binOp
      | exp op=('+' | '-') exp                         #binOp
      | exp op=('<' | '<=' | '>' | '>=') exp           #binOp
      | exp op=('==' | '!=') exp                       #binOp
      | exp op='&&' exp                                #binOp
      | exp op='||' exp                                #binOp
      | <assoc=right> exp '?' exp ':' exp              #condOp
      | ID                                             #id
      | ID '.' ID                                      #idDot
      | FLOAT                                          #float
      | BOOL                                           #bool
      ;

BOOL  : 'true' | 'false';
NEG   : '-';
ID    : [a-zA-Z_]([a-zA-Z0-9_])*;
FLOAT : [0-9]+('.'[0-9]+)?;
WS    : [ \n\t\r]+ -> channel(HIDDEN);