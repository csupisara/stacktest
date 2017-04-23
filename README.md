# Stack Testing

## Testing Result
Test|Type0|Type1|Explanation
————————————————————|—————————————|——————|--------:
testCapacity()|Passed|Passed|-
testNecessaryCapacity()|Passed|Passed|-
testIsEmpty()|Passed|Passed|-
testIsFull()|Passed|Failed|Stack should be full when the size is same as the capacity.
testPeek()|Failed|Failed|When push some elements into stack, the peek should return the same element every times and not alter the stack.
testPopEmptyStack()|Passed|Passed|-
testPopSize()|Passed|Failed|Pop will remove the top stack.
testPopReturn()|Passed|Passed -
testPushNullThrowsException()|Passed|Failed|If push null to the stack, it will throws IllegalArgumentException.
testOverflow()|Failed|Failed|If push is called when stack is full, it will throws IllegalStateException.
testNewStackIsEmpty()|Passed|Passed|-
testSize()|Passed|Failed|Return the number of items in the stack.

## All Test
``` testCapacity() ``` The stack capacity need to be the same as the capacity that we initialize before testing.

``` testNecessaryCapacity() ``` Stack capacity never be negative number.

``` testIsEmpty() ``` Test that IsEmpty method is working correctly.

``` testIsFull() ``` Stack should be full when the size is same as the capacity.

``` testPeek() ``` When push some elements into stack, the peek should return the same element every times and not alter the stack.

``` testPopEmptyStack() ``` If the stack is Empty and want to pop, it will throw an exception.

``` testPopSize() ``` Remove it from the stack when calling pop.

``` testPopReturn() ``` Return the item on the top of the stack, and remove it from the stack.

``` testPushNullThrowsException() ``` If push null to the stack, it will throws IllegalArgumentException.

``` testOverflow() ``` If push is called when stack is full, it will throws IllegalStateException.

``` testNewStackIsEmpty() ``` New stack need to have empty size. (Not full)

``` testSize() ``` Return the number of items in the stack.
