grammar vq;
query
      : gradient expression EOF;

gradient
      : '[' oneGradient ',' oneGradient ']';

oneGradient 
      : ID ':' NEG? NAT
      | ID;

expression 
      : '(' expression ')'                                    #par
      | op ='-' expression                                    #unOp
      | op ='!' expression                                    #unOp
      | expression op=('*' | '/') expression                  #binOp
      | expression op=('+' | '-') expression                  #binOp
      | expression op=('<' | '<=' | '>' | '>=') expression    #binOp
      | expression op=('==' | '!=') expression                #binOp
      | expression op='&&' expression                         #binOp
      | expression op='||' expression                         #binOp
      | ID                                                    #id
      | ID '.' ID                                             #idDot
      | NAT                                                   #nat
      | FLOAT                                                 #float
      | BOOL                                                  #bool
      ;

BOOL  : 'true' | 'false';
NEG   : '-';
ID    : [a-zA-Z_]([a-zA-Z0-9_])* ;
NAT   : [0-9]+ ;
FLOAT : [0-9]+('.'[0-9]+)? ;
WS    : [ \n\t\r]+ -> channel(HIDDEN) ;