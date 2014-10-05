package Codility.Question1;

/**
 * Created by xiangji on 9/15/14.
 */
public class Question1 {
    class Result{
        public int min;
        public int max;
    }

    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T == null){
            return 0;
        }
        Result res = helper(T);
        return res.max - res.min;
    }

    public Result helper(Tree T){
        Result res;
        if(T == null){
            return null;
        }

        Result left = helper(T.l);
        Result right = helper(T.r);

        if(left == null && right != null){
            res = update(right, T.x);
        }
        else if(left != null && right == null){
            res = update(left, T.x);
        }
        else if(left != null && right != null){
            res = update(left, right, T.x);
        }
        else{
            res = update(T.x);
        }

        return res;
    }

    private Result update(Result c, int i){
        Result res = new Result();
        if(i < c.min){
            res.min = i;
            res.max = c.max;
        }
        else if(i > c.max){
            res.max = i;
            res.min = c.min;
        }
        else{
            res.max = c.max;
            res.min = c.min;
        }
        return res;
    }

    private Result update(int i){
        Result res = new Result();
        res.min = i;
        res.max = i;
        return res;
    }

    private Result update(Result left, Result right, int i){
        Result res = new Result();
        int l = 0;
        int r = 0;
        l = Math.abs(i-left.min) > Math.abs(i-left.max) ? Math.abs(i-left.min) : Math.abs(i-left.max);
        r = Math.abs(i-right.min) > Math.abs(i-right.max) ? Math.abs(i-right.min) : Math.abs(i-right.max);
        l = l > Math.abs(left.min-left.max) ? l : Math.abs(left.min - left.max);
        r = r > Math.abs(right.min-right.max) ? r : Math.abs(right.min - right.max);
        if(l > r){
            if(i < left.min){
                res.min = i;
                res.max = left.max;
            }
            else if(i > left.max){
                res.max = i;
                res.min = left.min;
            }
            else{
                res.max = left.max;
                res.min = left.min;
            }
        }
        else{
            if(i < right.min){
                res.min = i;
                res.max = right.max;
            }
            else if(i > right.max){
                res.max = i;
                res.min = right.min;
            }
            else{
                res.max = right.max;
                res.min = right.min;
            }
        }
        return res;
    }
}
