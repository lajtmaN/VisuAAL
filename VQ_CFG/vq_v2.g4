grammar vq;
query
    : gradient expression EOF;

gradient
    : '[' oneGradient ',' oneGradient ']';

oneGradient 
    : ID ':' NEG? NAT
    | ID;

expression 
    : '(' expression ')'
    | negUn ='-' expression
    | notUn ='!' expression
    | expression op='*' expression
    | expression op='/' expression
    | expression op=('+' | '-') expression
    | expression op=('<' | '<=' | '>' | '>=') expression
    | expression op=('==' | '!=') expression
    | expression op='&&' expression
    | expression op='||' expression
    | ID 
    | NAT 
    | FLOAT 
    | BOOL
    ;
    
BOOL: 'true' | 'false';
NEG : '-';
ID  : [a-zA-Z_]([a-zA-Z0-9_])* ;
NAT : [0-9]+ ;
FLOAT : [0-9]+('.'[0-9]+)? ;
WS  : [ \n\t\r]+ -> channel(HIDDEN) ;