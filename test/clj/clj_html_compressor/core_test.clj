(ns clj-html-compressor.core-test
  (:import [com.googlecode.htmlcompressor.compressor HtmlCompressor]
           [com.googlecode.htmlcompressor.compressor ClosureJavaScriptCompressor]
           [com.google.javascript.jscomp CompilationLevel]
           [java.util.regex Pattern])
  (:require [clojure.test :refer :all]
            [clj-html-compressor.core :refer [compress]]))

(def test-cases [{:title "test enabled"
                  :source "testEnabled.html"
                  :result "testEnabledResult.html"
                  :config {:enabled false}}
                 {:title "test remove commends"
                  :source "testRemoveComments.html"
                  :result "testRemoveCommentsResult.html"
                  :config {:remove-comments true
                           :remove-intertag-spaces true}}
                 {:source "testRemoveQuotes.html"
                  :result "testRemoveQuotesResult.html"
                  :config {:remove-quotes true}}
                 {:source "testRemoveMultiSpaces.html"
                  :result "testRemoveMultiSpacesResult.html"
                  :config {:remove-multi-spaces true}}
                 {:source "testRemoveIntertagSpaces.html"
                  :result "testRemoveIntertagSpacesResult.html"
                  :config {:remove-intertag-spaces true}}
                 {:source "testPreservePatterns.html"
                  :result "testPreservePatternsResult.html"
                  :config {:preserve-patterns [(HtmlCompressor/PHP_TAG_PATTERN)
                                               (HtmlCompressor/SERVER_SCRIPT_TAG_PATTERN )
                                               (HtmlCompressor/SERVER_SIDE_INCLUDE_PATTERN)
                                               (Pattern/compile "<jsp:.*?>" (bit-and (Pattern/DOTALL) (Pattern/CASE_INSENSITIVE)))]
                           :remove-comments true
                           :remove-intertag-spaces true}}
                 {:title "test compress js with yui"
                  :source "testCompressJavaScript.html"
                  :result "testCompressJavaScriptYuiResult.html"
                  :config {:compress-javascript true
                           :remove-intertag-spaces true}}
                 {:title "test compress js with closure compiler"
                  :source "testCompressJavaScript.html"
                  :result "testCompressJavaScriptClosureResult.html"
                  :config {:compress-javascript true
                           :javascript-compressor (ClosureJavaScriptCompressor. (CompilationLevel/ADVANCED_OPTIMIZATIONS))
                           :remove-intertag-spaces true}}
                 {:source "testCompressCss.html"
                  :result "testCompressCssResult.html"
                  :config {:compress-css true
                           :remove-intertag-spaces true}}
                 {:source "testCompress.html"
                  :result "testCompressResult.html"
                  :config {}}
                 {:source "testSimpleDoctype.html"
                  :result "testSimpleDoctypeResult.html"
                  :config {:simple-doctype true}}
                 {:source "testRemoveScriptAttributes.html"
                  :result "testRemoveScriptAttributesResult.html"
                  :config {:remove-script-attributes true}}
                 {:source "testRemoveStyleAttributes.html"
                  :result "testRemoveStyleAttributesResult.html"
                  :config {:remove-style-attributes true}}
                 {:source "testRemoveLinkAttributes.html"
                  :result "testRemoveLinkAttributesResult.html"
                  :config {:remove-link-attributes true}}
                 {:source "testRemoveFormAttributes.html"
                  :result "testRemoveFormAttributesResult.html"
                  :config {:remove-form-attributes true}}
                 {:source "testRemoveInputAttributes.html"
                  :result "testRemoveInputAttributesResult.html"
                  :config {:remove-input-attributes true}}
                 {:source "testRemoveJavaScriptProtocol.html"
                  :result "testRemoveJavaScriptProtocolResult.html"
                  :config {:remove-javascript-protocol true}}
                 {:source "testRemoveHttpProtocol.html"
                  :result "testRemoveHttpProtocolResult.html"
                  :config {:remove-http-protocol true}}
                 {:source "testRemoveHttpsProtocol.html"
                  :result "testRemoveHttpsProtocolResult.html"
                  :config {:remove-https-protocol true}}
                 {:source "testPreserveLineBreaks.html"
                  :result "testPreserveLineBreaksResult.html"
                  :config {:preserve-line-breaks true}}
                 {:source "testSurroundingSpaces.html"
                  :result "testSurroundingSpacesResult.html"
                  :config {:remove-intertag-spaces true
                           :remove-surrounding-spaces "p,br"}}])

(defn resolve-file [filename]
  (str "test/resources/html/" filename))

(defn read-file [filename]
  (slurp (resolve-file filename) :encoding "UTF-8"))

(deftest compress-test
  (testing "should pass test cases"
    (doseq [test-case test-cases]
      (let [sourceHtml (read-file (:source test-case))
            resultHtml (read-file (:result test-case))]
        (is (= resultHtml (compress (:config test-case) sourceHtml)) 
            (:title test-case))))))
