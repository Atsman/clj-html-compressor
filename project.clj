(defproject clj-html-compressor "0.0.1"
  :description "Clojure library for html compressing"
  :url "https://github.com/Atsman/clj-html-compressor"
  :author "Aleh Atsman (http://www.alehatsman.com)"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.googlecode.htmlcompressor/htmlcompressor "1.5.2"]
                 [com.google.javascript/closure-compiler "r1043"]
                 [com.yahoo.platform.yui/yuicompressor "2.4.6"]]
  :source-paths ["src/clj"]
  :test-paths ["test/clj"])
