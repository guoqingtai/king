<form class="form-signin" method="POST" action="<%=request.getContextPath()%>/login" name='f'>  
       <h2 class="form-signin-heading">Please sign in</h2>  
       <input type="text" class="input-block-level" placeholder="User" name="username">  
       <input type="password" class="input-block-level" placeholder="Password" name="password">  
       <label class="checkbox">  
         <input type="checkbox" value="remember-me" name="remember_me"> Remember me  
       </label>  
       <button class="btn btn-large btn-primary" type="submit">Sign in</button>  
     </form>  