/*
 * Ext JS Library 3.4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */
Ext.ux.Reorderer=Ext.extend(Object,{defaults:{animate:true,animationDuration:0.2,defaultReorderable:false},constructor:function(a){Ext.apply(this,a||{},this.defaults);},init:function(d){this.target=d;this.initEvents();var a=this.getItems(),c=a.length,b;for(b=0;b<c;b++){this.createIfReorderable(a[b]);}},reorder:function(b){var a=this.target;if(a.fireEvent("before-reorder",b,a,this)!==false){this.doReorder(b);a.fireEvent("reorder",b,a,this);}},doReorder:function(a){throw new Error("doReorder must be implemented in the Ext.ux.Reorderer subclass");},createItemDD:function(a){throw new Error("createItemDD must be implemented in the Ext.ux.Reorderer subclass");},createItemDD:function(a){var b=a.getEl(),e=b.id,d=this.target,c=this;a.dd=new Ext.dd.DD(b,undefined,{isTarget:false});a.dd.constrainTo(d.getEl());a.dd.setYConstraint(0,0,0);Ext.apply(a.dd,{b4StartDrag:function(){this.startPosition=b.getXY();this.startZIndex=b.getStyle("zIndex");b.setStyle("zIndex",10000);a.suspendEvents();},onDrag:function(j){var o=b.getXY()[0],g=o-this.startPosition[0],k=d.items.items,m=k.indexOf(a),n;for(var i=0;i<k.length;i++){var q=k[i];if(q.reorderable&&q.id!=a.id){var h=q.getEl().getBox(),p=(c.buttonXCache[q.id]||h.x)+(h.width/2),f=m>i&&g<0&&o<p,l=m<i&&g>0&&(o+b.getWidth())>p;if(f||l){c[f?"onMovedLeft":"onMovedRight"](a,i,m);break;}}}},endDrag:function(){c.updateButtonXCache();b.moveTo(c.buttonXCache[a.id],undefined,{duration:c.animationDuration,scope:this,callback:function(){a.resumeEvents();d.fireEvent("reordered",a,d);}});b.setStyle("zIndex",this.startZIndex);}});},createIfReorderable:function(a){if(this.defaultReorderable&&a.reorderable==undefined){a.reorderable=true;}if(a.reorderable&&!a.dd){if(a.rendered){this.createItemDD(a);}else{a.on("render",this.createItemDD.createDelegate(this,[a]),this,{single:true});}}},getItems:function(){return this.target.items.items;},initEvents:function(){this.target.addEvents("before-reorder","reorder");}});Ext.ux.HBoxReorderer=Ext.extend(Ext.ux.Reorderer,{init:function(a){this.buttonXCache={};a.on({scope:this,add:function(b,c){this.createIfReorderable(c);}});Ext.ux.HBoxReorderer.superclass.init.apply(this,arguments);},createItemDD:function(a){if(a.dd!=undefined){return;}var c=a.getEl(),f=c.id,d=this,e=d.target;a.dd=new Ext.dd.DD(c,undefined,{isTarget:false});c.applyStyles({position:"absolute"});var b=function(){return false;};Ext.apply(a.dd,{b4StartDrag:function(){this.startPosition=c.getXY();this.startZIndex=c.getStyle("zIndex");c.setStyle("zIndex",10000);a.suspendEvents();if(a.menu){a.menu.on("beforeshow",b,d);}},startDrag:function(){this.constrainTo(e.getEl());this.setYConstraint(0,0,0);},onDrag:function(l){var q=c.getXY()[0],i=q-this.startPosition[0],m=e.items.items,h=m.length,o=m.indexOf(a),p,k,s;for(k=0;k<h;k++){s=m[k];if(s.reorderable&&s.id!=a.id){var j=s.getEl().getBox(),r=(d.buttonXCache[s.id]||j.x)+(j.width/2),g=o>k&&i<0&&q<r,n=o<k&&i>0&&(q+c.getWidth())>r;if(g||n){d[g?"onMovedLeft":"onMovedRight"](a,k,o);break;}}}},endDrag:function(){d.updateButtonXCache();c.moveTo(d.buttonXCache[a.id],c.getY(),{duration:d.animationDuration,scope:this,callback:function(){a.resumeEvents();if(a.menu){a.menu.un("beforeshow",b,d);}e.fireEvent("reordered",a,e);}});c.setStyle("zIndex",this.startZIndex);}});},onMovedLeft:function(j,i,h){var d=this.target,g=d.items.items,c=g.length,f;if(i!=undefined&&i!=h){d.remove(j,false);d.insert(i,j);this.updateButtonXCache();for(f=0;f<c;f++){var e=g[f],a=this.buttonXCache[e.id];if(j==e){j.dd.startPosition[0]=a;}else{var b=e.getEl();b.moveTo(a,b.getY(),{duration:this.animationDuration});}}}},onMovedRight:function(b,a,c){this.onMovedLeft.apply(this,arguments);},updateButtonXCache:function(){var c=this.target,a=c.items,b=c.getEl().getBox(true).x;a.each(function(d){this.buttonXCache[d.id]=b;b+=d.getEl().getWidth();},this);}});