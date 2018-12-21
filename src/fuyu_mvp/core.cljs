(ns fuyu_mvp.core
    (:require [goog.dom :as dom]
              [reagent.core :as r]
              [fuyu_mvp.components.app :as app]))

(enable-console-print!)

(defn render []
  (r/render [app/main] (dom/getElement  "app")))

(render)
(defn on-js-reload [] (render))
