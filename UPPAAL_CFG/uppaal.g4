grammar uppaal;
            xta : declaration* EOF;
    declaration : functionDecl | variableDecl | typeDecl | procDecl ;
  instantiation : ID '=' ID '(' argList ')' ';'
				| ID ':=' ID '(' argList ')' ';' ;
         system : 'system' ID (',' ID)* ';'  ;

  parameterList : '(' ( parameter ( ',' parameter )* )? ')' ;
      parameter : type ( '&' )? ID arrayDecl* ;

   functionDecl : type ID parameterList block ;

       procDecl : 'process' ID parameterList '{' procBody '}' ;
       procBody : (functionDecl | variableDecl | typeDecl)*
                    states (commit)? (urgent)? init (transitions)? ;

         states : 'state' stateDecl (',' stateDecl)* ';' ;
      stateDecl : ID ( '{' expression '}' )? ;
                                
         commit : 'commit' stateList ';' ;
         urgent : 'urgent' stateList ';' ;
      stateList : ID (',' ID)* ;

           init : 'init' ID ';' ;


    transitions : 'trans' transition (',' transitionOpt)* ';'  ;
     transition : ID '-' ID transitionBody ;
  transitionOpt : transition | '-' ID transitionBody  ;
 transitionBody : '{' (guard)? (sync)? (assign)? '}' ;

          guard : 'guard' expression ';' ;
           sync : 'sync' expression ('!' | '?') ';' ;
         assign : 'assign' exprList ';' ;

       typeDecl : 'typedef' type typeIdList (',' typeIdList)* ';'  ;
     typeIdList : ID arrayDecl* ;


   variableDecl : type declId (',' declId)* ';'  ;
         declId : ID arrayDecl* ( '=' initialiser )? 
				| ID arrayDecl* ( ':=' initialiser )? ;
    initialiser : expression 
                 |  '{' fieldInit ( ',' fieldInit )* '}' ;
      fieldInit : ( ID ':' )? initialiser ;

      arrayDecl : '[' expression ']' ;

           type : prefix ID ( range )?
                 |  prefix 'struct' '{' fieldDecl+ '}' ;
      fieldDecl : type fieldDeclId (',' fieldDeclId)* ';' ;
    fieldDeclId : ID arrayDecl* ;

         prefix : ( ( 'urgent' )? ( 'broadcast' )? | ('const' )? | ('meta')? ) ;
		 range : '[' expression ',' expression ']' ;

block : '{' ( variableDecl | typeDecl )* statement* '}' ;

statement : block
           | ';'
           |  expression ';'
           |  'for' '(' exprList ';' exprList ';' exprList ')' statement
		   |  'for' '(' ID ':' type ')' statement
           |  'while' '(' exprList ')' statement
           |  'do' statement 'while' '(' exprList ')' ';'
           |  'if' '(' exprList ')' statement ( 'else' statement )?
           |  'break' ';'
           |  'continue' ';'
           |  'switch' '(' exprList ')' '{' caseExpr+ '}'
           |  'return' ';'
           |  'return' expression ';'
           ;

caseExpr       : 'case' expression ':' statement*
           |  'default' ':' statement* 
           ;

  exprList : expression ( ',' expression )* ;
 expression :   ID
            |   NAT 
            |   FLOAT
            |   'true' 
            |  'false' 
            |   ID '(' argList ')'
            |   expression '[' expression ']'
            |   '(' expression ')'
            |   expression '++' 
            |   '++' expression
            |   expression '--'
            |   '--' expression
            |   expression assignOp expression
            |   unaryOp expression
            |   expression rel expression
            |   expression binIntOp expression
            |   expression binBoolOp expression
            |   expression '?' expression ':' expression
            |   expression '.' ID
            |   expression '\''
            |  'exists' '('ID ':' type ')' expression
            |  'forall' '('ID ':' type ')' expression
            ; 

    argList : (expression ( ',' expression )* )? ;

   assignOp : '=' | ':=' | '+=' | '-=' | '*=' | '/=' | '%=' 
            | '|=' | '&=' | '^=' | '<<=' | '>>=' ;
    unaryOp : '-' | '!'  | '+';
        rel : '<' | '<=' | '==' | '!=' | '>=' | '>' ;
   binIntOp : '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '<<' | '>>'  ;
  binBoolOp : '&&' | '||' ;
    
    ID  : [a-zA-Z_]([a-zA-Z0-9_])* ;
    NAT : [0-9]+ ;
    FLOAT : [0-9]+('.'[0-9]+)? ;
    WS  : [ \n\t\r]+ -> channel(HIDDEN) ;
    BLOCK_COMMENT
        : '/*' .*? '*/' -> channel(HIDDEN)
        ;
    LINE_COMMENT
        : '//' ~[\r\n]* -> channel(HIDDEN)
        ;