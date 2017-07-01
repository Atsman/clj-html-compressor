(ns clj-html-compressor.core
  (:import [com.googlecode.htmlcompressor.compressor HtmlCompressor]))

(def ^:private default-config 
  {:compress-css false
   :css-compressor nil
   :compress-javascript false
   :javascript-compressor nil
   :enabled true
   :generate-statistics false
   :preserve-line-breaks false
   :preserve-patterns nil
   :remove-comments true
   :remove-form-attributes false
   :remove-http-protocol false
   :remove-https-protocol false
   :remove-input-attributes false
   :remove-intertag-spaces false
   :remove-javascript-protocol false
   :remove-link-attributes false
   :remove-multi-spaces true
   :remove-quotes false
   :remove-script-attributes false
   :remove-style-attributes false
   :remove-surrounding-spaces nil
   :simple-boolean-attributes false
   :simple-doctype false
   :yui-css-line-break -1
   :yui-error-reporter nil
   :yui-js-disable-optimizations false
   :yui-js-line-break -1
   :yui-js-no-munge false
   :yui-js-preserve-all-semicolons false})

(defn- prepare-config [config]
  (merge default-config config))

(defn- html-compressor [config]
  (let [compressor (HtmlCompressor.)]
    (.setCompressCss compressor (:compress-css config))
    (.setCssCompressor compressor (:css-compressor config))
    (.setCompressJavaScript compressor (:compress-javascript config))
    (.setJavaScriptCompressor compressor (:javascript-compressor config))
    (.setEnabled compressor (:enabled config))
    (.setGenerateStatistics compressor (:generate-statistics config))
    (.setPreserveLineBreaks compressor (:preserve-line-breaks config))
    (.setPreservePatterns compressor (:preserve-patterns config))
    (.setRemoveComments compressor (:remove-comments config))
    (.setRemoveFormAttributes compressor (:remove-form-attributes config))
    (.setRemoveHttpProtocol compressor (:remove-http-protocol config))
    (.setRemoveHttpsProtocol compressor (:remove-https-protocol config))
    (.setRemoveInputAttributes compressor (:remove-input-attributes config))
    (.setRemoveIntertagSpaces compressor (:remove-intertag-spaces config))
    (.setRemoveJavaScriptProtocol compressor (:remove-javascript-protocol config))
    (.setRemoveLinkAttributes compressor (:remove-link-attributes config))
    (.setRemoveMultiSpaces compressor (:remove-multi-spaces config))
    (.setRemoveQuotes compressor (:remove-quotes config))
    (.setRemoveScriptAttributes compressor (:remove-script-attributes config))
    (.setRemoveStyleAttributes compressor (:remove-style-attributes config))
    (.setRemoveSurroundingSpaces compressor (:remove-surrounding-spaces config))
    (.setSimpleBooleanAttributes compressor (:simple-boolean-attributes config))
    (.setSimpleDoctype compressor (:simple-doctype config))
    (.setYuiCssLineBreak compressor (:yui-css-line-break config))
    (.setYuiErrorReporter compressor (:yui-error-reporter config))
    (.setYuiJsDisableOptimizations compressor (:yui-js-disable-optimizations config))
    (.setYuiJsLineBreak compressor (:yui-js-line-break config))
    (.setYuiJsNoMunge compressor (:yui-js-no-munge config))
    (.setYuiJsPreserveAllSemiColons compressor (:yui-js-preserve-all-semicolons config))
    compressor))

(defn compress 
  ([html] (compress {} html))
  ([config html] (let [config (prepare-config config)
                        compressor (html-compressor config)]
                    (.compress compressor html))))
