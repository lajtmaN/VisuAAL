grammar vq;
      query : gradient? expression EOF;

    gradient: '[' ID ':' NEG? NAT ',' ID ':' NEG? NAT ']';

 expression :   ID
            |   NAT 
            |   FLOAT
            |   BOOL
            |   parExpr
            |   unaryOp expression
            |   expression rel expression
            |   expression binBoolOp expression
            |   expression binIntOp expression
            ;

    parExpr : '(' expression ')';
    unaryOp : '-' | '!'  | '+';
        rel : '<' | '<=' | '==' | '!=' | '>=' | '>' ;
   binIntOp : '+' | '-' | '*' | '/' | '%' ;
  binBoolOp : '&&' | '||' ;
    
    BOOL: 'true' | 'false';
    NEG : '-';
    ID  : [a-zA-Z_]([a-zA-Z0-9_])* ;
    NAT : [0-9]+ ;
    FLOAT : [0-9]+('.'[0-9]+)? ;
    WS  : [ \n\t\r]+ -> channel(HIDDEN) ;